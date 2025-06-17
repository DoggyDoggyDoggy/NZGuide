package denys.diomaxius.nzguide.data.remote.mapper

import denys.diomaxius.nzevents.domain.model.Image
import denys.diomaxius.nzevents.domain.model.ImageTransform
import denys.diomaxius.nzevents.domain.model.ImageWrapper
import denys.diomaxius.nzevents.domain.model.TransformWrapper
import denys.diomaxius.nzguide.data.remote.dto.ImageDto
import denys.diomaxius.nzguide.data.remote.dto.ImageTransformDto
import denys.diomaxius.nzguide.data.remote.dto.ImageWrapperDto
import denys.diomaxius.nzguide.data.remote.dto.TransformWrapperDto

fun ImageWrapperDto.toDomain(): ImageWrapper = ImageWrapper(
    images = this.images.map { it.toDomain()  }
)

fun ImageDto.toDomain() : Image = Image(
    id = this.id,
    isPrimary = this.isPrimary,
    originalUrl = this.originalUrl,
    transforms = this.transforms.toDomain()
)

fun TransformWrapperDto.toDomain(): TransformWrapper = TransformWrapper(
    transforms = this.transforms.map { it.toDomain() }
)

fun ImageTransformDto.toDomain(): ImageTransform = ImageTransform(
    transformationId = this.transformationId,
    url = this.url,
    width = this.width,
    height = this.height
)