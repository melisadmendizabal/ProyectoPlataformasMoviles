package com.uvg.freetofeel.data.network
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import com.uvg.freetofeel.BuildConfig
import io.github.jan.supabase.SupabaseClientBuilder
import io.ktor.client.engine.cio.CIO

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_KEY,
    ) {
        install(GoTrue)
    }
}
