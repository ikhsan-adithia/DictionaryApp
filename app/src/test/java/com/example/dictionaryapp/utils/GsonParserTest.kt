package com.example.dictionaryapp.utils

import com.example.dictionaryapp.domain.model.TestModel
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test

class GsonParserTest {

    private lateinit var gsonParser: GsonParser

    @Before
    fun init() {
        gsonParser = GsonParser(Gson())
    }

    @Test
    fun `fromJson success with complete attribute`() {
        // given
        val json = """{"name": "john doe", "age": 22, "hobby": null}"""

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        val then = TestModel(name = "john doe", age = 22, hobby = null)
        assert(result != null)
        assert(result is TestModel)
        assert(result?.name == then.name)
        assert(result?.age == then.age)
        assert(result?.hobby == then.hobby)
    }

    @Test
    fun `fromJson success with null optional attribute`() {
        // given
        val json = """{"name": "john doe", "age": 22}"""

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        val then = TestModel(name = "john doe", age = 22, hobby = null)
        assert(result != null)
        assert(result is TestModel)
        assert(result?.name == then.name)
        assert(result?.age == then.age)
        assert(result?.hobby == then.hobby)
    }

    @Test
    fun `fromJson success with non-malformed json`() {
        // given
        val json = """{}"""

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        assert(result is TestModel)
        assert(result?.name == null)
        assert(result?.age == 0)
        assert(result?.hobby == null)
    }

    @Test
    fun `fromJson fail with malformed json`() {
        // given
        val json = """{"name": "john doe" "age": 22 "hobby": null}"""

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        assert(result == null)
    }

    @Test
    fun `fromJson fail with empty json`() {
        // given
        val json = ""

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        assert(result == null)
    }

    @Test
    fun `fromJson fail with wrong given value`() {
        // given
        val json = "5"

        // when
        val result: TestModel? = gsonParser.fromJson<TestModel>(json, TestModel::class.java)

        // then
        assert(result == null)
    }

    @Test
    fun `toJson success`() {
        // given
        val data = TestModel("john doe", 22, null)

        // when
        val result = gsonParser.toJson(data, TestModel::class.java)

        // then
        assert(result is String)
        assert(result != null)

        val then = result?.let { gsonParser.fromJson<TestModel>(it, TestModel::class.java) }
        assert(then is TestModel)
        assert(then != null)
        assert(then?.name == "john doe")
        assert(then?.age == 22)
        assert(then?.hobby == null)
    }

    @Test
    fun `toJson fail given null value`() {
        // given
        val data = null

        // when
        val result = gsonParser.toJson(data, TestModel::class.java)

        // then
        assert(result == "null")

        val then = result?.let { gsonParser.fromJson<TestModel>(it, TestModel::class.java) }
        assert(then == null)
    }
}