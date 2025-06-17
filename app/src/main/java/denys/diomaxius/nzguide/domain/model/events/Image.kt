package denys.diomaxius.nzguide.domain.model.events

data class Image(
    val id: Long,
    val isPrimary: Boolean,
    val originalUrl: String,
    val transforms: TransformWrapper
)
