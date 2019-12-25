package com.example.demo.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * 현재 로그인한 사용자를 감시하는 component
 * @author songe
 *
 */
@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("AdminServer");
	}

}
