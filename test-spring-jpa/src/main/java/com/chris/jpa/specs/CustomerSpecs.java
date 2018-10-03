package com.chris.jpa.specs;

import static com.google.common.collect.Iterators.toArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

public class CustomerSpecs {

	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {

		final Class<T> type = (Class<T>) example.getClass();

		return new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();

				EntityType<T> entity = entityManager.getMetamodel().entity(type);

				for (Attribute<T, ?> attribute : entity.getDeclaredAttributes()) {
					Object attrValue = getValue(example, attribute);
					if (attrValue != null) {
						if (attribute.getJavaType() == String.class) {
							if (!StringUtils.isEmpty(attrValue)) {
								predicates.add(cb.like(root.get(attribute(entity, attribute.getName(), String.class)),
										pattern((String) attrValue)));
							}
						} else {
							predicates.add(cb.equal(
									root.get(attribute(entity, attribute.getName(), attrValue.getClass())), attrValue));
						}
					}
				}
				return predicates.isEmpty() ? cb.conjunction()
						: cb.and(toArray(predicates.iterator(), Predicate.class));
				
			}

			private <T> Object getValue(T example, Attribute<T, ?> attribute) {
				return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);

			}

			private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName,
					Class<E> fieldClass) {
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);

			}
		};

	}

	static private String pattern(String str) {
		return "%" + str + "%";
	}

}
