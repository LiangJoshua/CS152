import subprocess

# Be cautious using "shell=True".
# Bad things can happen if a user controls the command.
p = subprocess.Popen("ls -l", shell=True, stdout=subprocess.PIPE)
for bline in p.stdout:
  line = bline.decode('utf-8').rstrip('\n')
  print(line)

