package denys.diomaxius.nzguide.domain.model.util

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val throwable: Throwable): Resource<Nothing>()
}