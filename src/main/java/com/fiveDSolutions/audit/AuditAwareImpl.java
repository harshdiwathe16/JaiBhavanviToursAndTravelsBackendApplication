package com.fiveDSolutions.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * File Name: AuditAwareImpl.java
 * Entity: AuditAwareImpl
 * Package: com.s2p.StudentSelfReflection.auditing
 * Author: pranayramteke
 * Date: 30/06/25
 * Description:
 */

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}
