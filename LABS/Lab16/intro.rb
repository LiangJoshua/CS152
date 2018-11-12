#Reference: http://ruby-doc.com/docs/ProgrammingRuby/

module RevString
  def to_rev_s
    to_s.reverse
  end
end

class Person

  include Comparable

  #include RevString

  #attr_reader :name
  #attr_writer :name
  attr_accessor :name

  def initialize name
    @name = name
  end

  #def to_s
  #  return @name
  #end


  def <=>(other)
    @name <=> other.name
  end

  ## Getter
  #def name
  #  return @name
  #end

  ## Setter
  #def name= newName
  #  @name = newName
  #end

  def has_name?
    return name != nil # return is optional; value is returned automatically.
  end

  def say_hi
    puts "Hello, my name is #{@name}."
  end
end

bob = Person.new "Bob"
bob.say_hi
bob.name = 'Robert'
bob.say_hi

puts "The person's first name is #{bob.name}"


alice = Person.new "Alice"

if bob < alice
  puts "bob"
else
  puts "alice"
end

class Person # Re-opening class
  include RevString
  def to_s
    @name
  end
end


puts alice.to_s
puts alice.to_rev_s

