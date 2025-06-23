package denys.diomaxius.nzguide.domain.model.events

data class Event(
    val id: String,
    val url: String,
    val name: String,
    val description: String,
    val datetimeStart: String,
    val datetimeEnd: String,
    val address: String,
    val sessions: SessionsWrapper,
    val images: ImageWrapper
) {
    companion object {
        fun empty(id: String = "") = Event(
            id = id,
            url = "",
            name = "",
            description = "",
            datetimeStart = "",
            datetimeEnd = "",
            address = "",
            sessions = SessionsWrapper(
                sessions = emptyList()
            ),
            images = ImageWrapper(
                images = listOf(
                    Image(
                        id = 0,
                        isPrimary = false,
                        originalUrl = "",
                        transforms = TransformWrapper(
                            transforms = listOf(
                                ImageTransform(
                                    transformationId = 0,
                                    url = "",
                                    width = 0,
                                    height = 0
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}