package com.ranyell.escola.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.repositories.AlunoRepository;
import com.ranyell.escola.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AlunoRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Aluno cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}
}