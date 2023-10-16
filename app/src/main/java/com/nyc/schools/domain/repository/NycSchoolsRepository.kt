package com.nyc.schools.domain.repository

import com.nyc.schools.data.model.landing.SchoolListItem
import retrofit2.Response

/**
 * Job: Serve as an interface for NycSchoolsRepository.
 *
 * @author Ketan
 */
fun interface  NycSchoolsRepository{
    suspend fun getSchools(): Response<List<SchoolListItem>>
}