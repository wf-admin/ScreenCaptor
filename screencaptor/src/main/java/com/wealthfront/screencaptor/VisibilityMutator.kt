package com.wealthfront.screencaptor

import android.view.View

class VisibilityMutator : ViewMutator2<Int, Int>() {
  override fun key(): Int = R.id.visibility_mutator_id

  override fun originalViewState(view: View): Int = view.visibility

  override fun mutateView(view: View, value: Int) {
    view.visibility = value
  }

  override fun restoreView(view: View, value: Int) {
    view.visibility = value
  }
}