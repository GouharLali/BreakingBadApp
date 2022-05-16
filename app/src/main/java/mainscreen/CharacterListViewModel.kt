package mainscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CharacterListViewModel() : ViewModel() {
    private val _actor = mutableStateOf<Domain.Character?>(null)
    val actor: State<Domain.Character?> = _actor

    init {
        _actor.value = Domain.Character(
            id = 1,
            name = "Actor 1",
            null,
            emptyList(),
            null,
            null,
            null,
            emptyList(),
            null,
            emptyList(),
        )
    }
}