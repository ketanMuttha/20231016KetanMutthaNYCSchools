package com.nyc.schools.data.repository

import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.data.remote.NycSchoolsAPI
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response
import java.net.HttpURLConnection

class NycSchoolsRepositoryImplTest {

    @Mock
    lateinit var nycSchoolsAPI: NycSchoolsAPI

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun nycSchoolsRepository_getSchools_verifyEmptySchoolList() = runTest {
            Mockito.`when`(nycSchoolsAPI.getSchools()).thenReturn(Response.success(emptyList()))
            val repository = NycSchoolsRepositoryImpl(nycSchoolsAPI)
            val result = repository.getSchools()
            assertEquals(true, result.isSuccessful)
            assertEquals(0, result.body()?.size)
    }

    @Test
    fun nycSchoolsRepository_getSchools_verifyValidSchoolList() = runTest {
        val schoolListItem = SchoolListItem(
            school_name = "north point"
        )
        val schoolListItems = mutableListOf<SchoolListItem>()
        schoolListItems.add(schoolListItem)
        Mockito.`when`(nycSchoolsAPI.getSchools()).thenReturn(Response.success(schoolListItems))
        val repository = NycSchoolsRepositoryImpl(nycSchoolsAPI)
        val result = repository.getSchools()
        assertEquals(1, result.body()?.size)
    }

    @Test
    fun nycSchoolsRepository_getSchools_verifyError() = runTest {

        Mockito.`when`(nycSchoolsAPI.getSchools()).thenReturn(Response.error(HttpURLConnection.HTTP_UNAUTHORIZED, "{}".toResponseBody()))
        val repository = NycSchoolsRepositoryImpl(nycSchoolsAPI)
        val result = repository.getSchools()
        assertEquals(false, result.isSuccessful)
    }

}