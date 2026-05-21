package in.abdulmajid.cardiq.category.repository;

import in.abdulmajid.cardiq.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}