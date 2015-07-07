package com.eharmony.aloha.dataset.csv

import com.eharmony.aloha.dataset.{Spec, FeatureExtractorFunction}

final case class CsvSpec[-A](features: FeatureExtractorFunction[A, String], separator: String = ",")
    extends Spec[A] {
    def apply(data: A) = {
        val (missing, values) = features(data)
        (missing, values.mkString(separator))
    }
}