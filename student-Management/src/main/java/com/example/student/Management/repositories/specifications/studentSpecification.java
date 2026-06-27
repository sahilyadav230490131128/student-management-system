package com.example.student.Management.repositories.specifications;

import com.example.student.Management.entities.Enrollment;
import com.example.student.Management.entities.Student;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class studentSpecification {
    public static Specification<Student> hasName(String name)
    {
        return ((root, query, cb) -> cb.like(root.get("name"),"%"+name+"%"));
    }
    public static Specification<Student> hasEmail(String email)
    {
        return ((root, query, cb) -> cb.equal(root.get("email"),email));
    }
    public static Specification<Student> hasAgeBetween(Integer minAge,Integer maxAge)
    {
        return ((root, query, cb) -> cb.between(root.get("age"), minAge,maxAge));
    }

}
