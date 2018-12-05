import sublime, sublime_plugin

class DuplicateCommand(sublime_plugin.TextCommand):
  def run(self, edit):
    for region in self.view.sel():
      if region.empty():
        line = self.view.line(region)
        contents = self.view.substr(line) + '\n'
        self.view.insert(edit, line.begin(), contents)
