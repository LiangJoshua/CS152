import sublime
import sublime_plugin
import subprocess
import os.path

def filetype(path):
    splitfile = path.split('.')
    return splitfile[len(splitfile) - 1]

def parentdir(path):
	pathsplit = path.split('/')
	return '/'.join(pathsplit[:len(pathsplit) - 1])

class BycoCommand(sublime_plugin.TextCommand):
	def run(self, view):
		filepath = sublime.Window.active_view(sublime.active_window())
		print(filepath.file_name())
		path = parentdir(filepath.file_name())
		print(path)
		print (filetype(filepath.file_name()))
		if filetype(filepath.file_name()) == 'byco':
			command = "ruby %s/vm.rb %s" % (path, filepath.file_name())
			print(command)
			proc = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
			for bline in proc.stdout:
				line = bline.decode('utf-8').rstrip('\n')
				print(line)

class EventListener(sublime_plugin.EventListener):

	def on_post_save(self, view):
		print("Saved!")
		filepath = view.file_name()
		print (filepath)
		ext = filetype(filepath)
		destpath = filepath.replace(ext, "byco")  
		path = parentdir(filepath)
		if ext == 'myscm':
			command = "ruby %s/compiler.rb %s %s" % (path, filepath, destpath)
			subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
			print("ran %s" % command)