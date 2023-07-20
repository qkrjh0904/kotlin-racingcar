package step3.view

import step3.objects.InputDevice
import step3.view.ViewMessage.INPUT_RACING_CAR_NUM_MESSAGE
import step3.view.ViewMessage.INPUT_TRY_NUM_MESSAGE

class InputView {
    companion object {
        fun inputRacingCarNum(): Int {
            println(INPUT_RACING_CAR_NUM_MESSAGE.message)
            return InputDevice.input()
        }

        fun inputTryNum(): Int {
            println(INPUT_TRY_NUM_MESSAGE.message)
            return InputDevice.input()
        }
    }
}
