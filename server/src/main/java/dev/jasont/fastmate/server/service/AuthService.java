package dev.jasont.fastmate.server.service;

import dev.jasont.fastmate.server.model.Credentials;
import dev.jasont.fastmate.server.model.User;
import dev.jasont.fastmate.server.repository.CredentialsRepository;
import dev.jasont.fastmate.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    CredentialsRepository credentialsRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var credentials = credentialsRepository.findByUsername(username);

        if(credentials.isEmpty())
            throw new UsernameNotFoundException("username: " + username);

        return org.springframework.security.core.userdetails.User.builder().username(credentials.get().getUsername())
                .password(credentials.get().getEncryptedPassword())
                .roles("USER").build();
    }

    public boolean register(String username, String rawPassword) {
        var conflictingCredentials = credentialsRepository.findByUsername(username);

        if(conflictingCredentials.isPresent())
            return false;

        var credentials = new Credentials(username, rawPassword);
        var user = new User(credentials);
        userRepository.save(user);

        return true;
    }
}
