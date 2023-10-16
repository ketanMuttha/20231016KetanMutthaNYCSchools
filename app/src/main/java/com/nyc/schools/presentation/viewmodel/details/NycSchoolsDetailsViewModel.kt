package com.nyc.schools.presentation.viewmodel.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyc.schools.data.model.details.NycSchoolDetailsScreenStateTO
import com.nyc.schools.data.model.landing.SchoolListItem
import com.nyc.schools.domain.GetNycSchoolDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Job: Serve as a ViewModel for NycSchool details screen.
 *
 * @author Ketan
 */
@HiltViewModel
class NycSchoolsDetailsViewModel @Inject constructor(
    private val getNycSchoolDetailsUseCase: GetNycSchoolDetailsUseCase
) : ViewModel(){

    private val _state : MutableState<NycSchoolDetailsScreenStateTO> = mutableStateOf(NycSchoolDetailsScreenStateTO.Loading)
    val state: State<NycSchoolDetailsScreenStateTO>
        get() = _state


    fun initScreen(schoolListItem: SchoolListItem):State<NycSchoolDetailsScreenStateTO> {
        viewModelScope.launch {
            val response = getNycSchoolDetailsUseCase.invoke(schoolListItem.dbn, schoolListItem)
                if (response.isSuccessful && !response.body().isNullOrEmpty()){
                    response.body()?.let { schoolSatScoresTOs ->
                        if (schoolSatScoresTOs.isNotEmpty()) {
                            val schoolSatScoresTO = schoolSatScoresTOs[0]
                            _state.value = NycSchoolDetailsScreenStateTO.NycSchoolDetailsContentTO(
                                schoolSatScoresTO = schoolSatScoresTO,
                                schoolListItem = schoolListItem
                            )
                        } else {
                            _state.value = NycSchoolDetailsScreenStateTO.Error
                        }
                    }
                } else{
                    _state.value = NycSchoolDetailsScreenStateTO.Error
            }
        }
        return state
    }

}