File.open('temp.txt', 'r') do |file|
  file.each_line { |line| puts line }
end

#file = File.open('temp.txt', 'r')
#file.each_line do |line|
#  puts line
#end
#file.close

