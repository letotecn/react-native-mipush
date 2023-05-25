
Pod::Spec.new do |s|
  s.name         = "react-native-letote-xmpush"
  s.version      = "2.2.0"
  s.summary      = "react-native-letote-xmpush"
  s.description  = <<-DESC
                   react-native-letote-xmpush
                   DESC
  s.homepage     = "https://github.com/fangasvsass/react-native-mipush"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/fangasvsass/react-native-mipush.git", :tag => "master" }
  s.source_files  = "ios/**/**/*.{h,m}"
  s.requires_arc = true


  s.vendored_libraries = "ios/**/**/libMiPushSDK.a"


  s.dependency "React"
  #s.dependency "others"

end

  
