=begin
Ruby provides a number of hooks that allow a developer
to change the behavior of objects.
The design is similar to JavaScript's Proxies (both are
metaobject protocols), but unlike proxies,
these hooks apply for all objects.

The most famous of these is method_missing,
based on Smalltalk's doesNotUnderstand:.
=end

class Person
  attr_accessor :name
  def initialize name
    @name = name
  end
end

bob = Person.new "Robert"
#bob.say_hi #Gives an error for an undefined method

class << bob
  def method_missing m
    phrase = m.to_s.sub /say_(.*)/, '\1'
    puts phrase
  end
end

bob.say_hi
bob.say_fancy
bob.say_goodnightGracie

# That's cute, but is it useful?  Consider Ruby on Rails.
# With Rails you refer to a record's fields by their names.
# We will (crudely) simulate that.
class Record
  def initialize fields
    @fields = fields
  end

  def set_field name, value
    @fields.name = value
  end
  def get_field name
    @fields.name
  end

  def method_missing m, *args
    @fields[m] = args[0] if args[0]
    @fields[m]
  end
end

r = Record.new ({ :fname => 'Rick', :lname => 'Grimes', :profession => 'Police Officer' })
puts r.profession
r.profession 'Zombie hunter'
puts r.profession

# Ruby has const_missing as well, which works in a similar manner, except that it applies
# to missing class constants


