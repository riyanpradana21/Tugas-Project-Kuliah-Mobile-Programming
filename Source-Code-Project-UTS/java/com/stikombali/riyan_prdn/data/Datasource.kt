package com.stikombali.riyan_prdn.data

import com.stikombali.riyan_prdn.R
import com.stikombali.riyan_prdn.model.Galeri

class Datasource() {

    fun loadAffirmations(): List<Galeri> {
        return listOf<Galeri>(
                Galeri(1, R.string.affirmation1, R.drawable.asset_landing1),
                Galeri(2, R.string.affirmation2, R.drawable.asset_landing2),
                Galeri(3, R.string.affirmation3, R.drawable.asset_landing3),
                Galeri(4, R.string.affirmation4, R.drawable.asset_landing4),
                Galeri(5, R.string.affirmation5, R.drawable.asset_landing5),
                Galeri(6, R.string.affirmation6, R.drawable.asset_landing6)
        )
    }
}

