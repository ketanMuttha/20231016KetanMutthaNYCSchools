package com.nyc.schools.domain

import com.nyc.schools.data.model.details.SchoolSatScoresTO
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.domain.repository.NycSchoolDetailsRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Job: Serve as a use case for NycSchoolDetailsRepository.
 *
 * @author Ketan
 */
class GetNycSchoolDetailsUseCase @Inject constructor(private val nycSchoolDetailsRepository: NycSchoolDetailsRepository){

    suspend operator fun invoke(dbn: String, schoolListItem: SchoolListItem): Response<List<SchoolSatScoresTO>> {
        return nycSchoolDetailsRepository.getSatScores(dbn, schoolListItem)
    }
}