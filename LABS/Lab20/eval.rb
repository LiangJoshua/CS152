# Ruby has rich metaprogramming tools, often bowered from Smalltalk.
# Like JavaScript, it has an eval feature.
prog = "puts 3 + 4"
eval prog

# Eval is one of the most powerful metaprogramming features,
# but it is also one of the most dangerous.
print "Please enter your method name: "
m = gets.chomp
eval "def #{m}; puts 'Hi!'; end"
eval m

=begin
Thomass-MacBook-Pro-3:lab15 taustin$ ruby eval.rb 
Please enter your method name: abc; end; puts "Mwah, hah, hah!"; #
Mwah, hah, hah!
eval.rb:11: (eval):1: compile error (SyntaxError)
(eval):1: syntax error, unexpected kEND, expecting $end
abc; end; puts "Mwah, hah, hah!"; #
-----------------------
Eval is horribly abused (Richards et al. 2011, See the Eval that men do,), but it is useful at times.
For instance, in JavaScript, it served as an early (but unsafe) version of JSON.parse.
Similar to goto, it is a powerful but dangerous construct, and is often used in places
where the language is missing a key feature.
"A design pattern is the sincerest form of feature request".

However, it does not tend to show up as often in Ruby.
In part, Ruby has some safer alternatives that are nearly as powerful.
They take blocks rather than expressions.
=end

# instance_eval -- used for prying open objects to get at their private data.
# This can be handy for things like writing a debugger.
class Person
  attr_reader :name
  def initialize name
    @name = name
  end
end

bob = Person.new "Robert"
puts bob.name
#bob.name = "Bobby" # Error

bob.instance_eval do
  @name = "Bobby"
end
puts bob.name

# And finally class_eval/module_eval, which serve as an alternate way of opening up a class.
favorite_song = "Streets of Laredo"
class Person
  #puts favorite_song # error
end

Person.class_eval do
  puts favorite_song
  #def sing
  #  puts "When #{@name} went out in the #{favorite_song}..." # Will not see favorite_song
  #end
  define_method "sing" do
    puts "When #{@name} went out in the #{favorite_song}..."
  end
end

bob.sing

