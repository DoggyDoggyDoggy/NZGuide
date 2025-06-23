package denys.diomaxius.nzguide.domain.model.events

data class ImageTransform(
    val transformationId: Int,
    val url: String,
    val width: Int,
    val height: Int
)