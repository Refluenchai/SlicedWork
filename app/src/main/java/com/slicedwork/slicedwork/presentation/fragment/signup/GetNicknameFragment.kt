package com.slicedwork.slicedwork.presentation.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.slicedwork.slicedwork.databinding.FragmentGetNicknameBinding
import com.slicedwork.slicedwork.domain.model.User
import com.slicedwork.slicedwork.presentation.viewmodel.signup.GetNicknameViewModel
import com.slicedwork.slicedwork.util.extensions.focusAndShowSoftKeyboard
import com.slicedwork.slicedwork.util.extensions.hideKeyBoard

class GetNicknameFragment : Fragment() {

    private lateinit var _binding: FragmentGetNicknameBinding
    private lateinit var _user: User
    private val _viewModel: GetNicknameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setProps(inflater)

        return _binding.root
    }

    override fun onResume() {
        super.onResume()
        setListeners()
    }

    private fun setProps(inflater: LayoutInflater) {
        _binding = FragmentGetNicknameBinding.inflate(inflater)

        _binding.run {
            viewModel = _viewModel
            lifecycleOwner = viewLifecycleOwner
            tietNickname.focusAndShowSoftKeyboard(requireContext())
        }
    }

    private fun setListeners() {
        _binding.btnNext.setOnClickListener {
            it.hideKeyBoard(requireContext())
            getUser()
            setUserProps()
            goToGetEmail()
        }
    }

    private fun getUser() {
        _user = arguments?.get("user") as User
    }

    private fun setUserProps() {
        _user.nickname = _viewModel.nicknameLiveData.value.toString()
    }

    private fun goToGetEmail() =
        findNavController().navigate(
            GetNicknameFragmentDirections.actionGetNicknameFragmentToGetEmailFragment(_user)
        )
}