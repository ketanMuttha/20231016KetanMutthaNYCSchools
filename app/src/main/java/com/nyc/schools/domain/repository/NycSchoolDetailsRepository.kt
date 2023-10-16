package com.nyc.schools.domain.repository

import com.nyc.schools.data.model.details.SchoolSatScoresTO
import com.nyc.schools.data.model.landing.SchoolListItem
import retrofit2.Response

/**
 * Job: Serve as an interface for NycSchoolDetailsRepository.
 *
 * @author Ketan
 */
fun interface  NycSchoolDetailsRepository{
    suspend fun getSatScores(dbn: String, schoolListItem: SchoolListItem): Response<List<SchoolSatScoresTO>>
}