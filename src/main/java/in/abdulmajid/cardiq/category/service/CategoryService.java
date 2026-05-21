package in.abdulmajid.cardiq.category.service;

import in.abdulmajid.cardiq.category.dto.CategoryResponse;
import in.abdulmajid.cardiq.category.dto.CreateCategoryRequest;
import in.abdulmajid.cardiq.category.entity.Category;
import in.abdulmajid.cardiq.category.repository.CategoryRepository;
import in.abdulmajid.cardiq.exception.DuplicateResourceException;
import in.abdulmajid.cardiq.exception.ResourceNotFoundException;
import in.abdulmajid.cardiq.offer.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final OfferRepository offerRepository;

    public CategoryResponse createCategory(
            CreateCategoryRequest request
    ) {

        if (categoryRepository.existsByNameIgnoreCase(request.getName())) {
            throw new DuplicateResourceException("Category already exists");
        }

        Category category = new Category();

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category savedCategory = categoryRepository.save(category);

        return mapToResponse(savedCategory);
    }

    public List<CategoryResponse> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CategoryResponse getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found")
                );

        return mapToResponse(category);
    }

    public CategoryResponse updateCategory(
            Long id,
            CreateCategoryRequest request
    ) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found")
                );

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return mapToResponse(updatedCategory);
    }

    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found")
                );
        if (offerRepository.existsByCategory_Id(id)) {
            throw new DuplicateResourceException(
                    "Cannot delete category because offers are associated with it"
            );
        }

        categoryRepository.delete(category);
    }

    private CategoryResponse mapToResponse(
            Category category
    ) {

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}