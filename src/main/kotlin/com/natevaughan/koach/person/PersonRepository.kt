package com.natevaughan.koach.person

import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by nate on 7/23/17
 */
@RepositoryRestResource
interface PersonRepository {
    fun findByLastName(@Param("name") name: String): List<Person>
}