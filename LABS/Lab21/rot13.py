import sublime
import sublime_plugin

import codecs # for rot13


class Rot13Command(sublime_plugin.TextCommand):
  def run(self, edit):
    #self.view.insert(edit, 0, "Hello, World!")
    for region in self.view.sel():
      if not region.empty():
        s = self.view.substr(region)
        enc = codecs.getencoder("rot-13")
        ciphertext = enc(s)[0]
        self.view.replace(edit, region, ciphertext)

