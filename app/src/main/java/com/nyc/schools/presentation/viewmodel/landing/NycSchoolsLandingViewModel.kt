package com.nyc.schools.presentation.viewmodel.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyc.schools.data.model.landing.NycSchoolsLandingScreenStateTO
import com.nyc.schools.domain.GetNycSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Job: Serve as a ViewModel for NycSchools landing screen.
 *
 * @author Ketan
 */
@HiltViewModel
class NycSchoolsLandingViewModel @Inject constructor(
    private val getNycSchoolsUseCase: GetNycSchoolsUseCase
) : ViewModel() {

    private val _state: MutableState<NycSchoolsLandingScreenStateTO> =
        mutableStateOf(NycSchoolsLandingScreenStateTO.Loading)
    val state: State<NycSchoolsLandingScreenStateTO>
        get() = _state

    init {
        getSchoolsList()
    }

    private fun getSchoolsList() = viewModelScope.launch {
        val response = getNycSchoolsUseCase()
        if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            response.body()?.let { schoolListItems ->
                if (schoolListItems.isNotEmpty()) {
                    _state.value =
                        NycSchoolsLandingScreenStateTO.NycSchoolsContentTO(schoolListItems)
                } else {
                    _state.value = NycSchoolsLandingScreenStateTO.ErrorTO
                }
            }
        } else {
            _state.value = NycSchoolsLandingScreenStateTO.ErrorTO
        }
    }
}