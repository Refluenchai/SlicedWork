package com.slicedwork.slicedwork.data.repository

import com.slicedwork.slicedwork.domain.model.Vacancy

interface VacancyRepository {
    suspend fun registerVacancy(vacancy: Vacancy)
}