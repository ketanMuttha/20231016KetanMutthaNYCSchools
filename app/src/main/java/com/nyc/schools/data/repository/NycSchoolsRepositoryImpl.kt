package com.nyc.schools.data.repository

import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.data.remote.NycSchoolsAPI
import com.nyc.schools.domain.repository.NycSchoolsRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Job: Retrieve data for the  nyc schools landing screen.
 *
 * @author Ketan
 */
class NycSchoolsRepositoryImpl @Inject constructor(private val nycSchoolsAPI: NycSchoolsAPI) : NycSchoolsRepository {

    override suspend fun getSchools():Response<List<SchoolListItem>> {
        return nycSchoolsAPI.getSchools()
    }
}