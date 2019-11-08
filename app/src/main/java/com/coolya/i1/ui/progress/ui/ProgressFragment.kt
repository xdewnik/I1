package com.coolya.i1.ui.progress.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import com.coolya.i1.R
import com.coolya.i1.data.ToDo
import com.coolya.i1.databinding.FragmentProgressBinding
import com.coolya.i1.ui.base.BaseFragment
import com.coolya.i1.ui.progress.vm.ProgressViewModel
import kotlinx.android.synthetic.main.fragment_progress.*
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import kotlin.math.roundToInt

class ProgressFragment : BaseFragment<FragmentProgressBinding>() {
    override fun setAppBarTitle(): String? = "ПЛЮС УЛЬТРА"

    override fun setLayoutId(): Int = R.layout.fragment_progress

    private val currentTodo by lazy { arguments!!.getParcelable<ToDo>("todo") }

    private val viewModel by viewModel<ProgressViewModel> {
        parametersOf(
            arguments!!.getParcelable<ToDo>(
                "todo"
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.delegate = ProgressDelegate(viewModel)
        progress.setOnSeekBarChangeListener(object :
            CircularSeekBar.OnCircularSeekBarChangeListener {
            override fun onProgressChanged(
                circularSeekBar: CircularSeekBar?,
                progress: Float,
                fromUser: Boolean
            ) {
            }

            override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {
                seekBar?.let {
                    if (seekBar.progress.roundToInt() == 100) {
                        val afd = requireContext().assets.openFd("music/plus_ultra.mp3")
                        val player = MediaPlayer()
                        player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                        player.prepare()
                        player.start()
                    }
                    viewModel.updateTodo(seekBar.progress.roundToInt())

                }
            }

        })
    }
}