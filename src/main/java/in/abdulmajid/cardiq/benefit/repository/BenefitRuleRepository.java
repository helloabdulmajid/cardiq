package in.abdulmajid.cardiq.benefit.repository;

import in.abdulmajid.cardiq.benefit.entity.BenefitRule;
import in.abdulmajid.cardiq.common.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitRuleRepository extends JpaRepository<BenefitRule,Long> {
}
