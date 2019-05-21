package shimpigggy.com.bmicalculator

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferenceUtil {

    //kotiln의 static!!
    public companion object {
        val KEY_H = "KEY_HEIGHT"
        val KEY_W = "KEY_WEIGHT"

        fun saveDate(context: Context, weight: Int, height: Int): Unit {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()

            editor.putInt(KEY_H, height)
                .putInt(KEY_W, weight)
                .apply()
        }

        public fun loadHeight(context: Context): Int {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)

            return pref.getInt(KEY_H, 0)
        }

        public fun loadWeight(context: Context): Int {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)

            return pref.getInt(KEY_W, 0)
        }

        public fun removeDataHeight(context: Context): Unit {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = pref.edit()

            editor.remove(KEY_H)
                .apply()
        }

        public fun removeDataWeight(context: Context): Unit {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = pref.edit()

            editor.remove(KEY_W)
                .apply()
        }

        public fun removeDataAll(context: Context): Unit {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = pref.edit()

            editor.clear()
                .apply()
        }
    }
}