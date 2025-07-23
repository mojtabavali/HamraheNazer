package com.nezammohandesi.hamrehenazer.data.model.enum

import com.nezammohandesi.hamrehenazer.utils.EnumInfo

enum class PostType(private val type: Int) {
    @EnumInfo("ناظر عمران")
    NazerOmran(1),
    @EnumInfo("ناظر هماهنگ کننده")
    NazerHamahangKonnande(2),
    @EnumInfo("سازنده")
    builder(3),
    @EnumInfo("مالک")
    owner(4),
    @EnumInfo("ناظر معماری")
    NazerMemar(5),
    @EnumInfo("سایر")
    Other(6);


    companion object {

        fun fromInteger(x: Int): PostType? {
            when (x) {
                1 -> return NazerOmran
                2 -> return NazerHamahangKonnande
                3 -> return builder
                4 -> return owner
                5 -> return NazerMemar
                6 -> return Other
            }
            return null
        }

        fun toInteger(x: PostType): Int? {
            return when (x) {
                NazerOmran -> 1
                NazerHamahangKonnande -> 2
                builder -> 3
                owner -> 4
                NazerMemar -> 5
                Other -> 6
            }

        }
    }
}