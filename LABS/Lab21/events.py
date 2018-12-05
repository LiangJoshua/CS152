import sublime
import sublime_plugin

import subprocess  # for Popen

class EventDump(sublime_plugin.EventListener):
  def on_load(self, view):
    print(view.file_name() + " just got loaded")

  def on_new(self, view):
    print("New file created")

