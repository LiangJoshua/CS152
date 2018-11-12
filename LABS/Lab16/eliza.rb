#! /usr/bin/ruby -w

#Represents a Rogerian psychiatrist
class Shrink

  #initializes 'memory' of Eliza.
  def initialize()
    @he="he"
    @she="she"
  end

  #read a statement and convert it to a psychiatric response.
  def generateResponse(blather)
    #downcase for ease of substitution
    blather = blather.downcase

    #change 'you', 'your', etc. to uppercase 'I', 'MY'
    blather.gsub!(/\byour\b/,"MY")
    blather.gsub!(/\byou\b/,'I')

    #Replace 'my' with 'your', 'me' with 'you', 'I' with 'you', etc.
    blather.gsub!(/\bmy\b/,"YOUR")
    blather.gsub!(/\bme\b/,"YOU")
    blather.gsub!(/\bi\b/,'YOU')
    blather.gsub!(/\bare\b/,'AM')
    blather.gsub!(/\bam\b/,'ARE')

    #Sub in past references, but only for the 1st occurrence or it looks weird
    blather.sub!(/\b(he|him)\b/, @he)
    blather.sub!(/\b(she|her)\b/, @she)

    if @he!="he"
      blather.sub!(/\b(they)\b/, @he)
    elsif @she!="she"
      blather.sub!(/\b(they)\b/, @she)
    end

    # Always|never
    blather = "CAN YOU BE MORE SPECIFIC" if blather =~ /\b(always|never)\b/

    # Are you...
    blather.gsub!(/\AAM I\b/, "IS IT IMPORTANT IF I AM")

    # Replace 'you was' with 'you were'...
    blather.gsub!(/\bYOU was\b/, "YOU WERE")

    # Well|Perhaps
    blather.gsub!(/\A(well, |perhaps |well |perhaps, )/, "")

    #Get future references -- note that these do NOT change the immediate output
    hePat=/.*\b(your (father|brother|(ex-?)?(husband|boyfriend)))\b.*/
    shePat = /.*\b(your (mother|sister|(ex-?)?(wife|girlfriend)))\b.*/
    @he=blather.sub(hePat, '\1').chomp if blather =~ hePat
    @she=blather.sub(shePat, '\1').chomp if blather =~ shePat

    #Deal with name
    namePat=/.*\byour name is (\w+).*/
    @name=blather.sub(namePat,'\1')
    blather.sub!(namePat,'nice to meet you, \1.  How can I help you')

    #results are uppercased, for aesthetics.
    return blather.upcase + "?"
  end
end


#main -- reads from standard input unless -test is the first parameter.
eliza = Shrink.new()
if ARGV[0] == "-test"
    ['My girlfriend never listens to me',
     "I think she might be deaf",
     "yes",
     "I am afraid of clowns",
     "Well, they just seem creepy",
     "Also, when I was a kid, a clown killed my dad",
      "Are you a clown in disguise?",
    ].each do |stmt|
        puts stmt
        puts eliza.generateResponse(stmt)
    end
else
  while line = gets
    response = eliza.generateResponse line
    puts response
  end
end
