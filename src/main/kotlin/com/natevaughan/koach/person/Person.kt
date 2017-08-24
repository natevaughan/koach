package com.natevaughan.koach.person


/**
 * Created by nate on 7/23/17
 */
//@Entity
class Person(firstName: String, lastName: String) {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 1

    val firstName: String = firstName
    val lastName: String = lastName
}