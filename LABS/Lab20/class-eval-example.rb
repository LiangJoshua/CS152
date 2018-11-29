class Class
  def my_attr_accessor(*args)
    args.each do |prop|
      # Creating the getter
      self.class_eval("def #{prop}; @#{prop}; end")
      # Creating the setter
      self.class_eval("def #{prop}=(v); @#{prop}=v; end")
    end
  end
end

class Musician
  my_attr_accessor :name, :genre, :instrument
end

m = Musician.new
m.name = "Norah Jones"
puts m.name

