package com.example.wordsapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OrderOfTestAnnotations {

    @Before
    fun setupFn() {
        println("Set up function")
    }

    @Test
    fun test_a() {
        println("Test a")
    }

    @Test
    fun test_b() {
        println("Test b")
    }

    @Test
    fun test_c() {
        println("Test c")
    }

    @After
    fun tearDownFn() {
        println("Tear down function")
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun setupClass() {
            println("Set up class")
        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            println("Tear down class")
        }
    }

}