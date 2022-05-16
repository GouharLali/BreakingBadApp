package Domain

data class Character(
    val id: Int,
    val name: String,
    val birthday: String?,
    val occupation: List<String?>,
    val img: String?,
    val status: String?,
    val nickname: String?,
    val appearance: List<String?>,
    val portrayed: String?,
    val category: List<String?>
)
