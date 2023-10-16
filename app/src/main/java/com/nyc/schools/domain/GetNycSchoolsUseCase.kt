package com.nyc.schools.domain

import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.domain.repository.NycSchoolsRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Job: Serve as a use case for NycSchoolsRepository.
 *
 * @author Ketan
 */
class GetNycSchoolsUseCase @Inject constructor(private val nycSchoolsRepository: NycSchoolsRepository){

    suspend operator fun invoke(): Response<List<SchoolListItem>> {
        return nycSchoolsRepository.getSchools()
    }
}