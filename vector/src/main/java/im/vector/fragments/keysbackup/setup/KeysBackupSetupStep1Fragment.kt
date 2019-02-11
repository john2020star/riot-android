/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.fragments.keysbackup.setup

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import butterknife.OnClick
import im.vector.R
import im.vector.fragments.VectorBaseFragment
import im.vector.ui.arch.LiveEvent

class KeysBackupSetupStep1Fragment : VectorBaseFragment() {

    companion object {
        fun newInstance() = KeysBackupSetupStep1Fragment()
    }

    override fun getLayoutResId() = R.layout.fragment_keys_backup_setup_step1

    private lateinit var viewModel: KeysBackupSetupSharedViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(KeysBackupSetupSharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

    }

    @OnClick(R.id.keys_backup_setup_step1_button)
    fun onButtonClick() {
        viewModel.navigateEvent.value = LiveEvent(KeysBackupSetupSharedViewModel.NAVIGATE_TO_STEP_2)
    }
}