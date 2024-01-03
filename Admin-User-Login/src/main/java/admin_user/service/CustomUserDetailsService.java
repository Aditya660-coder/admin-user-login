package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admin_user.model.User;
import admin_user.repositories.userRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private userRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userrepo.findByEmail(username);
		if(user== null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetail(user);
	}
	
	

}
