package com.nyc.schools.data.repository

import com.nyc.schools.data.model.details.SchoolSatScoresTO
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.data.remote.NycSchoolsAPI
import com.nyc.schools.domain.repository.NycSchoolDetailsRepository
import com.nyc.schools.domain.repository.NycSchoolsRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Job: Retrieve data for the nyc school details screen.
 *
 * @author Ketan
 */
class NycSchoolDetailsRepositoryImpl @Inject constructor(private val nycSchoolsAPI: NycSchoolsAPI) : NycSchoolDetailsRepository {

    override suspend fun getSatScores(dbn: String, schoolListItem: SchoolListItem):Response<List<SchoolSatScoresTO>> {
        return nycSchoolsAPI.getSchoolSatScores(dbn)
    }
}